package lt.psk.tools.mybatis.dao;

import java.util.List;
import lt.psk.tools.mybatis.model.Shop;

public interface ShopMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOP
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOP
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    int insert(Shop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOP
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    Shop selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOP
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    List<Shop> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOP
     *
     * @mbg.generated Mon May 02 20:27:54 EEST 2022
     */
    int updateByPrimaryKey(Shop record);
}