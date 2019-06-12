package upp.backend.model.dto;

public class TaskDTO {
	public String TaskId;
	
	public String Naziv;
	
	public TaskDTO() {
	}

	public TaskDTO(String taskId, String naziv) {
		super();
		TaskId = taskId;
		Naziv = naziv;
	}

	public String getTaskId() {
		return TaskId;
	}

	public void setTaskId(String taskId) {
		TaskId = taskId;
	}

	public String getNaziv() {
		return Naziv;
	}

	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	
	
	
	
}
