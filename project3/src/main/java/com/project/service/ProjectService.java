package com.project.service;

// com.project.service/ProjectService.java

import java.util.List;

import com.project.dto.ProjectDTO;
import com.project.dto.RichDTO;
import com.project.dto.ListDTO;

public interface ProjectService {

	List<ProjectDTO> selectProjectList() throws Exception;

	void insertProject(ProjectDTO projectDTO);

	void insertProject2(ProjectDTO projectDTO);

	void updateProject(ProjectDTO projectDTO);

	void deleteProject(ProjectDTO projectDTO);

	ProjectDTO loginProject(ProjectDTO projectDTO) throws Exception;

	List<ListDTO> listProject() throws Exception;

	void insertList(ListDTO listDTO);

	ListDTO listDetail(ListDTO listDTO) throws Exception;

	List<RichDTO> richList()throws Exception;

}