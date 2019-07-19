import React from 'react'; 

class SecondLandingRow extends React.Component { 
    constructor(props) {
        super(props);
        this.discountImageUrl = "https://shopperstar.s3.amazonaws.com/discount.png";
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
                                <div className="avds_title">Smart Phones</div>
                                <div className="avds_link"><a href="categories.html">See More</a></div>
                            </div>
                        </div>
                    </div>
                    <div className="avds_large">
                        <div className="avds_background" style={{ backgroundImage: `url(https://shopperstar.s3.amazonaws.com/avds_large.jpg)` }}></div>
                        <div className="avds_large_container">
                            <div className="avds_large_content">
                                <div className="avds_title">Professional Cameras</div>
                                <div className="avds_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros. Sed viver ra velit venenatis fermentum luctus.</div>
                                <div className="avds_link avds_link_large"><a href="categories.html">See More</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default SecondLandingRow;