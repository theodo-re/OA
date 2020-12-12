package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Folder;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.entity.Word;
import cn.bdqn.oaproject.param.Common;
import cn.bdqn.oaproject.param.UpdateInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordDao {
    /*查询公司文档*/
    List<Word> findWord(Common common);
    /* 查询文档总条数 */
    Integer findFileCount(Common common);
    /*添加文档*/
    Integer addCompanyFile(Word word);
    /*根据后缀查询文件类型id*/
    Integer findFileTypeByLastName(@Param("lastName") String lastname);
    /*根据id将文件状态改为回收站*/
    Integer updateFileStateByFileId(UpdateInfo info);
    /*查询规章制度*/
    List<Word> findSystemWord(Common common);
    /*查询规章制度总条数*/
    Integer findSystemCount(Common common);
    /*根据id获取文件绝对路径*/
    Word findFileAPathByFileId(@Param("id") Integer id);
    /*根据id查询用户*/
    Users findUserByid(@Param("userId") Integer userId);
    /*根据部门id 查询部门下的文件夹*/
    List<Folder> findFolderByDeptId(@Param("deptId")Integer deptId);
    /*根据部门id 查询部门下的文档*/
    List<Word> findDeptFileByDeptId(@Param("deptId")Integer deptId);
    /*添加文件夹*/
    Integer addFold(Folder folder);
    /*查询指定部门所有职员*/
    List<Users> findUsersByDeptId(@Param("deptId")Integer deptId);
    /*根据个人id查找个人文件夹*/
    Folder findFileApByUserId(@Param("userId")Integer userId);
    /*根据id  查询本人删除的文档*/
    List<Word>  findTrashWordByUserId(@Param("UserId")Integer userId);
    /*根据文档id删除文档*/
    Integer deleteWordByWordId(@Param("id")Integer id);
    /*根据文档id 还原  文档*/
    Integer updateWordByWordId(@Param("id")Integer id);
    /*根据文档id  获取文件绝对路径*/
    String findFileAPByid(@Param("id") Integer id);
    /*根据用户id获取职称*/
    Integer findUserZCByUserId(@Param("id")Integer id);
    /*根据用户id查询本人的文档*/
    List<Word> findWordByUserId(@Param("id")Integer id);







}
