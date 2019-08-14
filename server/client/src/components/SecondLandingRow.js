import React from 'react'; 

class SecondLandingRow extends React.Component { 
 
    constructor(props) {

        super(props);

        this.discountImageUrl = "https://shopperstar.s3.amazonaws.com/discount.png";
        this.smartPhoneDetailed = "product/5d507afb5366fd63a50066e0";
        this.professionalCameraDetailed = "product/5d507d585366fd63a50066e6";
    }

    render() { 
        return (
            <div className="avds">
                <div className="avds_container d-flex flex-lg-row flex-column align-items-start justify-content-between">
                    <div className="avds_small">
                        <div className="avds_background" style={{ backgroundImage: `url(https://shopperstar.s3.amazonaws.com/avds_small.jpg)` }}></div>
                        <div className="avds_small_inner">
                            <div className="avds_discount_container">
                                <img src={this.discountImageUrl} alt="" />
                                <div>
                                    <div className="avds_discount">
                                        <div>20<span>%</span></div>
                                        <div>Discount</div>
                                    </div>
                                </div>
                            </div>
                            <div className="avds_small_content">
                                <div className="avds_title">HTC 10 EVO 5.5</div>
                                <div className="avds_link"><a href={this.smartPhoneDetailed}>See More</a></div>
                            </div>
                        </div>
                    </div>
                    <div className="avds_large">
                        <div className="avds_background" style={{ backgroundImage: `url(https://shopperstar.s3.amazonaws.com/avds_large.jpg)` }}></div>
                        <div className="avds_large_container">
                            <div className="avds_large_content">
                                <div className="avds_title">Canon PowerShot SX420</div>
                                <div className="avds_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros. Sed viver ra velit venenatis fermentum luctus.</div>
                                <div className="avds_link avds_link_large"><a href={this.professionalCameraDetailed}>See More</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default SecondLandingRow;