package za.ac.uct.service;

import za.ac.uct.domain.Faq;

import java.util.ArrayList;

public interface IFaqService extends IService<Faq, Integer> {

    ArrayList<Faq> getAll();
}
