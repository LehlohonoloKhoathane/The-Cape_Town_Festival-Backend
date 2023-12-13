package za.ac.uct.service.impl;
/**
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 * */
import org.springframework.stereotype.Service;
import za.ac.uct.domain.ContactUs;
import za.ac.uct.repository.ContactUsRepository;
import za.ac.uct.service.IContactUsService;

import java.util.ArrayList;

@Service("ContactUsServiceImpl")
public class ContactUsServiceImpl implements IContactUsService {

    private ContactUsRepository repository;

    public ContactUsServiceImpl(ContactUsRepository repository){
        this.repository = repository;
    }
    @Override
    public ContactUs create(ContactUs contactUs) {
        return this.repository.save(contactUs);
    }

    @Override
    public ContactUs read(int id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public ContactUs update(ContactUs contactUs) {
        if (this.repository.existsById(contactUs.getId())){
            return this.repository.save(contactUs);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<ContactUs> findAll() {
        ArrayList<ContactUs> all = (ArrayList<ContactUs>) this.repository.findAll();
        return all;
    }


}
