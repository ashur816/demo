package service;

import common.ServiceFactory;
import dao.IStudyDAO;

/**
 * Created by Martin on 2015/8/12.
 */
public class StudySVImpl implements IStudySV {

    @Override
    public void getId() throws Exception {
        System.out.println("StudySVImpl:getId");
        IStudyDAO dao = (IStudyDAO)ServiceFactory.getService(IStudyDAO.class);
        dao.getId();
    }
}
