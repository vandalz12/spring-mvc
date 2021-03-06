package org.guestbook.domain;

import java.io.Serializable;
import java.util.Date;

public class Guest implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guests.guest_id
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    private String guestId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guests.guest_name
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    private String guestName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guests.address
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guests.guest_date
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    private Date guestDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table guests
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guests.guest_id
     *
     * @return the value of guests.guest_id
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    public String getGuestId() {
        return guestId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guests.guest_id
     *
     * @param guestId the value for guests.guest_id
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    public void setGuestId(String guestId) {
        this.guestId = guestId == null ? null : guestId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guests.guest_name
     *
     * @return the value of guests.guest_name
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guests.guest_name
     *
     * @param guestName the value for guests.guest_name
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName == null ? null : guestName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guests.address
     *
     * @return the value of guests.address
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guests.address
     *
     * @param address the value for guests.address
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guests.guest_date
     *
     * @return the value of guests.guest_date
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    public Date getGuestDate() {
        return guestDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guests.guest_date
     *
     * @param guestDate the value for guests.guest_date
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    public void setGuestDate(Date guestDate) {
        this.guestDate = guestDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guests
     *
     * @mbggenerated Mon Aug 20 14:43:53 ICT 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guestId=").append(guestId);
        sb.append(", guestName=").append(guestName);
        sb.append(", address=").append(address);
        sb.append(", guestDate=").append(guestDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}