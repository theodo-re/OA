package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Folder;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.entity.Word;
import cn.bdqn.oaproject.param.Common;

import java.util.List;
import java.util.Map;

public interface WordService {
    /*查询公司文档*/
    List<Word> findWordList(Common common);
    /*查询公司文档总条数*/
    Integer findCommonWordCount(Common common);
    /*添加公司文档*/
    Integer addCompanyFile(Word word);
    /*根据后缀名查询后缀id*/
    Integer findFileTypeByLastName(String lastName);
    /*根据id 修改文件状态为回收站*/
    Integer updateFileStateByFileId(Integer id);
    /*查询规章制度*/
    Map<String ,Object> findSystemList(Common common);
    /*根据id查询规章制度绝对路径*/
    Map<String ,Object> findFileAPByFileId(Integer id);
    /*根据id查询用户*/
    Users findUserById(Integer id);
    /*根据部门id查询文件夹*/
    List<Folder> findFolderByDeptId(Integer deptId);
    /*根据部门id查询部门文件*/
    List<Word> findDeptWordByDeptId(Integer deptId);
    /*添加文件夹*/
    Integer addFold(Folder folder);
    /*查询本部门所有用户*/
    List<Users> findUserByDeptId(Integer deptId);
    /*根据用户id查询用户文件夹地址*/
    Folder findfoldApByUserId(Integer id);
    /*根据用户id查询被删除文档*/
    List<Word> findTrashWordByUserId(Integer id);
    /*根据文档id  删除文档*/
    Integer delFileByFileId(Integer id);
    /*根据文档id  修改文档*/
    Integer updateFileByFileId(Integer id);
    /*根据用户id查询用户职称*/
    Integer findUserZCById(Integer id);
    /*根据用户id 查询个人文档*/
    List<Word> findWordListByUserId(Integer id);

}
