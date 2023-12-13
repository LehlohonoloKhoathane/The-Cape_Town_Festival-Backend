package za.ac.uct.service;

import za.ac.uct.domain.HelpCenter;

import java.util.ArrayList;

public interface IHelpCenterService extends IService<HelpCenter, Integer> {

    ArrayList<HelpCenter> getAll();
}
