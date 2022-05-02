package lt.psk.tools.mybatis.dao;

import java.util.List;
import lt.psk.tools.mybatis.model.Tool;

public interface ToolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TOOL
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TOOL
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    int insert(Tool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TOOL
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    Tool selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TOOL
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    List<Tool> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TOOL
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    int updateByPrimaryKey(Tool record);
}