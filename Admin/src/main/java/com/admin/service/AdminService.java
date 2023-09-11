package com.admin.service;

import java.util.List;

import com.admin.dto.LoginDto;
import com.admin.dto.LoginResultDto;
import com.admin.entity.Admin;
import com.admin.exceptions.AdminException;

public interface AdminService {
		
		public Admin deleteAdmin(int id) throws AdminException;
		public Admin viewAdminById(int id) throws AdminException;
		public Admin viewAdminByEmail(String email) throws AdminException;
		public List<Admin> getAllAdminList();
		public Admin registerAdmin( Admin admin) throws AdminException;
		public Admin updateAdmin(Admin Admin, int id) throws AdminException;
		public LoginResultDto validateAdmin(LoginDto loginDto) throws AdminException;
		

}

