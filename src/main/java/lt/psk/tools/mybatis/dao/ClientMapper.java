package lt.psk.tools.mybatis.dao;

import lt.psk.tools.mybatis.model.Client;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLIENT
     *
     * @mbg.generated Mon May 02 20:32:15 EEST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLIENT
     *
     * @mbg.generated Mon May 02 20:32:15 EEST 2022
     */
    int insert(Client record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLIENT
     *
     * @mbg.generated Mon May 02 20:32:15 EEST 2022
     */
    Client selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLIENT
     *
     * @mbg.generated Mon May 02 20:32:15 EEST 2022
     */
    List<Client> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLIENT
     *
     * @mbg.generated Mon May 02 20:32:15 EEST 2022
     */
    int updateByPrimaryKey(Client record);
}