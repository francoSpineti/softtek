package com.app.softtek.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.softtek.config.MessageProperties;
import com.app.softtek.dto.EmployeDto;
import com.app.softtek.entity.Employe;
import com.app.softtek.iservice.IEmployeService;
import com.app.softtek.repository.IEmployeRepository;
import com.app.softtek.utils.Validator;

@Service
public class EmployeServiceImpl implements IEmployeService{

	@Autowired
	private IEmployeRepository repository;

	@Autowired
	private MessageProperties messageProperties;
	
	@Override
	public Employe findByIdEmploye(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<EmployeDto> findAllEmployes() {
		return this.toListDto(repository.findAll());
	}

	@Override
	public ResponseEntity<EmployeDto> createEmploye(@RequestBody EmployeDto requestEntity) {
		Validator validator = this.validateABM(requestEntity, messageProperties.getCreateMessage(), messageProperties.getCreateError());
		if(validator.isSuccess()) {
			repository.save(toEntity(validator.getObj()));
			return ResponseEntity.ok(validator.getObj());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public Validator updateEmploye(@RequestBody EmployeDto requestEntity) {
		Validator validator = this.validateABM(requestEntity, messageProperties.getUpdateMessage(), messageProperties.getUpdateError());
		if(validator.isSuccess()) {
			Employe employeDB = this.findByIdEmploye(Long.valueOf(validator.getObj().getId()));
			if(employeDB == null) {
				validator.setMessage(messageProperties.getUpdateError());
				validator.setObj(null);
				validator.setSuccess(false);
			}else {
				employeDB.setName(validator.getObj().getName());
				employeDB.setLastName(validator.getObj().getLastName());
				employeDB.setDni(Integer.parseInt(validator.getObj().getDni()));
				employeDB.setActive(validator.getObj().isActive());
				repository.save(employeDB);
			}
		}
		return validator;
	}

	@Override
	public Validator deleteEmploye(Long id) {
		Employe employeDB = this.findByIdEmploye(id);
		Validator validator = this.validateABM(toDto(employeDB), messageProperties.getDeleteMessage(), messageProperties.getDeleteError());
		if(validator.isSuccess()) {
			repository.delete(employeDB);
		}
		return validator;
	}

	private EmployeDto toDto(Employe emp) {
		EmployeDto dto = new EmployeDto();
		if(emp == null) {
			return null;
		}
		dto.setId(String.valueOf(emp.getId()));
		dto.setName(emp.getName());
		dto.setLastName(emp.getLastName());
		dto.setDni(String.valueOf(emp.getDni()));
		dto.setActive(emp.isActive());	
		return dto;
	}
	
	private Employe toEntity(EmployeDto dto) {
		Employe emp = new Employe();
		emp.setId(Long.parseLong(dto.getId()));
		emp.setName(dto.getName());
		emp.setLastName(dto.getLastName());
		emp.setDni(Integer.valueOf(dto.getDni()));
		emp.setActive(dto.isActive());
		return emp;
	}
	
	private List<EmployeDto> toListDto(List<Employe> emp){
		List<EmployeDto> list = new ArrayList<EmployeDto>();
		for (Employe aux : emp) {
			EmployeDto dto = new EmployeDto();
			dto.setId(String.valueOf(aux.getId()));
			dto.setName(aux.getName());
			dto.setLastName(aux.getLastName());
			dto.setDni(String.valueOf(aux.getDni()));
			dto.setActive(aux.isActive());
			list.add(dto);
		}
		return list;
	}
	
	private Validator validateABM(EmployeDto dto,String message,String messageError) {
		Validator validator = new Validator();
		if(dto == null) {
			validator.setSuccess(false);
			validator.setMessage(messageError);
			validator.setObj(dto);
		}else {
			validator.setSuccess(true);
			validator.setMessage(message);
			validator.setObj(dto);
		}
		return validator;
	}
}
