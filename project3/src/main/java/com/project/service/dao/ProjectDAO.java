
package com.project.service.dao;

//com.project.service.dao/ProjectDAO.java

import java.util.List;

import com.project.dto.ProjectDTO;
import com.project.dto.RichDTO;
import com.project.dto.ListDTO;

public interface ProjectDAO {

	List<ProjectDTO> selectProjectList() throws Exception;

	void insertProject(ProjectDTO projectDTO);

	void insertProject2(ProjectDTO projectDTO);

	ProjectDTO loginProject(ProjectDTO projectDTO) throws Exception;

	void updateProject(ProjectDTO projectDTO);

	void deleteProject(ProjectDTO projectDTO);

	List<ListDTO> listProject() throws Exception;
	
	void insertList(ListDTO listDTO);
	
	ListDTO listDetail(ListDTO listDTO) throws Exception;

	List<RichDTO> richList()throws Exception;
}