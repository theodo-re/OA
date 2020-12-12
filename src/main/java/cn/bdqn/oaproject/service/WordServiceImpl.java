package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.WordDao;
import cn.bdqn.oaproject.entity.Folder;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.entity.Word;
import cn.bdqn.oaproject.param.Common;
import cn.bdqn.oaproject.param.UpdateInfo;
import cn.bdqn.oaproject.util.Fixed;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WordServiceImpl implements WordService {

    @Resource
    private WordDao wordDao;

    /*查询公司文档*/
    @Override
    public List<Word> findWordList(Common common) {
        common.setPageIndex((common.getPageIndex() - 1) * Fixed.PAGE_SIZE);
        common.setPageSize(Fixed.PAGE_SIZE);
        List<Word> list = wordDao.findWord(common);
        return list;
    }

    /*查询公司文档条数*/
    @Override
    public Integer findCommonWordCount(Common common) {
        Integer count = wordDao.findFileCount(common);
        return count;
    }


    /*添加公司文档*/
    @Override
    public Integer addCompanyFile(Word word) {
        Integer result = wordDao.addCompanyFile(word);
        return result;
    }

    /*查询文件类型id*/
    @Override
    public Integer findFileTypeByLastName(String lastName) {
        Integer id = wordDao.findFileTypeByLastName(lastName);
        return id;
    }

    /*根据id 修改文件状态为回收站*/
    @Override
    public Integer updateFileStateByFileId(Integer id,Integer userId,Integer state) {
        Date date=new Date();
        UpdateInfo info=new UpdateInfo();
        info.setId(id);
        info.setUserId(userId);
        info.setState(state);
        info.setDate(date);
        Integer result = wordDao.updateFileStateByFileId(info);
        return result;
    }

    @Override
    public Map<String, Object> findSystemList(Common common) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageIndex", common.getPageIndex());
        common.setPageIndex((common.getPageIndex() - 1) * Fixed.PAGE_SIZE);
        common.setPageSize(Fixed.PAGE_SIZE);
        List<Word> sysList = wordDao.findSystemWord(common);
        Integer SystemCount = wordDao.findSystemCount(common);
        int pageCount = 1;
        if (SystemCount != null) {
            if (SystemCount % Fixed.PAGE_SIZE != 0) {
                pageCount = (SystemCount / Fixed.PAGE_SIZE) + 1;
            } else {
                pageCount = SystemCount / Fixed.PAGE_SIZE;
            }
        }
        map.put("list", sysList);
        map.put("pageCount", pageCount);


        return map;
    }

    @Override
    public Map<String, Object> findFileAPByFileId(Integer id) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(id);
        Word word = wordDao.findFileAPathByFileId(id);
        map.put("system", word);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        if (word != null) {
            String ap = word.getFileAp();
            System.out.println("根据id获取的绝对路径：" + ap);
            File file = new File(ap);
            try {
                reader = new BufferedReader(new FileReader(file));
                String tempStr;
                while ((tempStr = reader.readLine()) != null) {
                    sbf.append(tempStr);
                }
                reader.close();
                System.out.println("文本内容：" + sbf.toString());
                map.put("text", sbf.toString());
                return map;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        System.out.println("文本内容：" + sbf.toString());
        map.put("text", sbf.toString());
        return map;

    }


    @Override
    public Users findUserById(Integer id) {
        Users user=wordDao.findUserByid(id);
        return user;
    }

    @Override
    public List<Folder> findFolderByDeptId(Integer deptId) {
        List<Folder> folders=wordDao.findFolderByDeptId(deptId);
        return folders;
    }


    @Override
    public List<Word> findDeptWordByDeptId(Integer deptId) {
        List<Word> words=wordDao.findDeptFileByDeptId(deptId);
        return words;
    }


    @Override
    public Integer addFold(Folder folder) {
        System.out.println("进入了service层");
        String ap=Fixed.DEPT_FILE_AP+folder.getFoldName()+"\\";
        String rp=Fixed.DEPT_FILE_RP+folder.getFoldName()+"\\";
        File file=new File(ap);
        System.out.println(ap);
        if (file.exists()){
            return -1;
        }else {
            folder.setFoldAp(ap);
            folder.setFoldRp(rp);
            file.mkdirs();
        }
        Integer result=wordDao.addFold(folder);
        return result;
    }

    @Override
    public List<Users> findUserByDeptId(Integer deptId) {
        List<Users> usersList=wordDao.findUsersByDeptId(deptId);
        return usersList;
    }

    @Override
    public Folder findfoldApByUserId(Integer id) {
        Folder folder=wordDao.findFileApByUserId(id);
        return folder;
    }


    @Override
    public List<Word> findTrashWordByUserId(Integer id) {
        List<Word> wordList=wordDao.findTrashWordByUserId(id);
        return wordList;
    }

    @Override
    public Integer delFileByFileId(Integer id) {
        Integer result=wordDao.deleteWordByWordId(id);
        if (result>0){
            String ap=wordDao.findFileAPByid(id);
            File file=new File(ap);
            if (file!=null){
                if (file.delete()){
                    return 1;
                }
            }

        }
        return 0;

    }

    @Override
    public Integer updateFileByFileId(Integer id) {
        Integer result=wordDao.updateWordByWordId(id);
        return result;
    }


    @Override
    public Integer findUserZCById(Integer id) {
        Integer result=wordDao.findUserZCByUserId(id);
        return result;
    }


    @Override
    public List<Word> findWordListByUserId(Integer id) {
        List<Word> words=wordDao.findWordByUserId(id);
        return words;
    }
}
