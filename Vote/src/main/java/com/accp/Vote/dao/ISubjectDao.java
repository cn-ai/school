package com.accp.Vote.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.Vote.pojo.item;
import com.accp.Vote.pojo.option;
import com.accp.Vote.pojo.subject;
/**
 * 
* @ClassName: ISubjectDao 
* @Description: ͶƱϵͳ���ݷ��ʽӿ���
* @author ����
* @date 2018��11��17�� ����3:46:13 
*
 */
public interface ISubjectDao {
	//��ѯ����ͶƱ�����ѡ��
	public List<subject> querySubject(@Param("subject")Object subject,@Param("type")String type);
	
	//�޸�ͣ��״̬
	public void updateSubjectType(@Param("subject")Object subject);
	
	//����ͶƱ
	public int saveSubject(@Param("subject")Object subject);
	//����ͶƱѡ�� 
	public void saveOptions(@Param("options")List<option> options,@Param("id")int id);
	
	//�޸�ͶƱ��Ϣ
	public void updateSubject(@Param("subject")Object subject);
	//ɾ���޸�֮ǰ��ѡ���Լ�֮ǰ�û������ѡ��
	public void deleteOptions(@Param("id")int id);
	
	//�鿴�û��Ƿ�����������
	public int queryWay(@Param("way")String way,@Param("item")item item);
	//�û�����ͶƱ
	public void saveItems(@Param("Items")List<item> Items);
	//�޸Ĳ���ͶƱ����
	public void updateJoin(@Param("sid")int sid);
	
	//ѡ��Ʊ��
	public List<option> queryItems(@Param("sid")Integer sid);
	
	//ÿ�ն�ʱ����ʱ���ѵ��ڵ�ͶƱ
	public int updateStoptype();
	
	
}
