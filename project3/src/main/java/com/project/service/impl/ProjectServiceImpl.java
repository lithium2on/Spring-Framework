package com.project.service.impl;

// com.project.service.impl/ProjectServiceImpl.java

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.ProjectDTO;
import com.project.dto.RichDTO;
import com.project.dto.ListDTO;
import com.project.service.ProjectService;
import com.project.service.dao.ProjectDAO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO projectMapper;

	@Override
	@Transactional
	public List<ProjectDTO> selectProjectList() throws Exception {
		return projectMapper.selectProjectList();
	}

	@Override
	public void insertProject(ProjectDTO projectDTO) {
		projectMapper.insertProject(projectDTO);
	}

	@Override
	public void insertProject2(ProjectDTO projectDTO) {
		projectMapper.insertProject2(projectDTO);
	}

	@Override
	public ProjectDTO loginProject(ProjectDTO projectDTO) throws Exception {
		return projectMapper.loginProject(projectDTO);
	}

	@Override
	public void updateProject(ProjectDTO projectDTO) {
		projectMapper.updateProject(projectDTO);
	}

	@Override
	public void deleteProject(ProjectDTO projectDTO) {
		projectMapper.deleteProject(projectDTO);
	}

	@Override
	public List<ListDTO> listProject() throws Exception {
		return projectMapper.listProject();
	}
	
	@Override
	public void insertList(ListDTO listDTO) {
		projectMapper.insertList(listDTO);
	}
	
	@Override
	public ListDTO listDetail(ListDTO listDTO) throws Exception {
		return projectMapper.listDetail(listDTO);
	}

	@Override
	@Transactional
	public List<RichDTO> richList() throws Exception {
		return projectMapper.richList();
	}
	
}