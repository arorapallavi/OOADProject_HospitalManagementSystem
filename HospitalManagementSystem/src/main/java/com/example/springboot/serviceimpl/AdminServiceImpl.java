package com.example.springboot.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Admin;
import com.example.springboot.repository.AdminRepository;
import com.example.springboot.service.AdminService;


@Service

public class AdminServiceImpl implements AdminService{

	@Autowired
	public AdminRepository adminRepository;
	
	@Override
	public Admin saveAdmin(Admin admin) {

			return adminRepository.save(admin);

	}

	@Override
	public Admin loginAdmin(Admin admin) {
	
		return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId, admin.adminPassword).orElseThrow(()->new ResourceNotFoundException("Admin ", "EmaildId",admin.adminEmailId+"and password "+admin.adminPassword));
	}

	@Override
	public List<Admin> getAllAdmins() {

		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(long adminId) {
	
		return adminRepository.findById(adminId).orElseThrow(()->new NoSuchElementException());
	}

	@Override
	public void deleteAdmin(long adminId) {
		 
		adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		adminRepository.deleteById(adminId);
		
	}

	@Override
	public Admin updateAdmin(Admin admin,long adminId) {
		
		Admin existingUser = adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		
		existingUser.setAddress(admin.getAddress());
		existingUser.setAdminEmailId(admin.getAdminEmailId());
		existingUser.setAdminPassword(admin.getAdminPassword());
		existingUser.setAge(admin.getAge());
		existingUser.setContactNumber(admin.getContactNumber());
		existingUser.setFirstName(admin.getFirstName());
		existingUser.setGender(admin.getGender());
		existingUser.setLastName(admin.getLastName());
		
		adminRepository.save(existingUser);
		
		return existingUser;
		
	}
	

}
