package org.jenjetsu.graduate_project.service;

import java.util.*;

import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.model.*;

public interface AppService {

    public void clearDatabase();

    public List<ForecastData> getForecastData();

    public List<ForecastMessageDto> calculateFireDanger(ForecastDataCalculateDto calculateDto);

}
