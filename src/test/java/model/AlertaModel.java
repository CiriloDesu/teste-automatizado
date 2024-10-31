package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class AlertaModel {
    @Expose(serialize = false)
    private int idAlerta;
    @Expose
    private int numeroAlerta;
    @Expose
    private String localAlerta;
    @Expose
    private String statusAlerta;
    @Expose
    private String dataAlerta;
}
