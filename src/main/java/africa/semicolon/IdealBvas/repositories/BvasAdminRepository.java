package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.Utils.AppUtils;
import africa.semicolon.IdealBvas.models.Admin;
import africa.semicolon.IdealBvas.models.UserInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasAdminRepository implements AdminRepository{
    List<Admin> admins = new ArrayList<>();
    private int id;

    @Override
    public Admin findById(String id) {
        for(Admin foundAdmin : admins){
            boolean sameAdmin = Objects.equals(foundAdmin.getId(),id);
            if(sameAdmin) return foundAdmin;
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return admins;
    }

//    @Override
//    public Admin save(Admin admin) {
//        admin.setId(generateId());
//        admins.add(admin);
//        id++;
//        return admin;
//    }
    @Override
    public Admin save(Admin admin) {
        admin.setId(AppUtils.generateId());
        admins.add(admin);
        return admin;
}
    private String generateId(){
        int AdminId = id + 1;
        return Integer.toString(AdminId);
    }

    @Override
    public void deleteById(String id) {
        Admin foundAdmin = findById(id);
        admins.remove(foundAdmin);
    }
    public int numberOfAdmins(){return admins.size();}
}
