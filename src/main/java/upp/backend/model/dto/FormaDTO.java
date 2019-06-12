package upp.backend.model.dto;

import java.util.List;

import org.camunda.bpm.engine.form.FormField;

public class FormaDTO {
	private String taskId;

    private List<FormField> polja;

    private String processId;

	public FormaDTO() {
		
	}
	
	public FormaDTO(String taskId, List<FormField> polja, String processId) {
		super();
		this.taskId = taskId;
		this.polja = polja;
		this.processId = processId;
	}
	
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public List<FormField> getpolja() {
		return polja;
	}

	public void setpolja(List<FormField> polja) {
		this.polja = polja;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
}
