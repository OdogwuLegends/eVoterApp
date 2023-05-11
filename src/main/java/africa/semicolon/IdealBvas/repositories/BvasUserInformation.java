package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.Utils.AppUtils;
import africa.semicolon.IdealBvas.models.UserInformation;

import java.util.ArrayList;
import java.util.List;

public class BvasUserInformation implements UserInformationRepository{
    List<UserInformation> informationList = new ArrayList<>();

    @Override
    public UserInformation findById(String id) {
        for(UserInformation information : informationList){
            if(information.getId().equals(id)) return information;
        }
        return null;
    }

    @Override
    public List<UserInformation> findAll() {
        return informationList;
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        String id = AppUtils.generateId();
        userInformation.setId(id);
        informationList.add(userInformation);
        return userInformation;
    }

    @Override
    public void deleteById(String id) {
        UserInformation userInformation = findById(id);
        if(userInformation!=null) informationList.remove(userInformation);
    }
}
