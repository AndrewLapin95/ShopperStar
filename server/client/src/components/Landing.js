import React from 'react';

import Newsletter from "./Newsletter";
import IconBoxes from "./IconBoxes";
import HomeContainer from "./HomeContainer";
import SecondLandingRow from "./SecondLandingRow";

class Landing extends React.Component {
    constructor(props) {

        super(props);

        this.firstProductUrl = "https://shopperstar.s3.amazonaws.com/product4_1.jpg";
        this.secondProductUrl = "https://shopperstar.s3.amazonaws.com/product8_1.jpg";
        this.thirdProductUrl = "https://shopperstar.s3.amazonaws.com/product13_1.jpg";
        this.fourthProductUrl = "https://shopperstar.s3.amazonaws.com/product18_1.jpg";

        this.headphonesDetailed = "product/5d507f015366fd63a50066ed";
    }

    render() { 
        return (
            <div className="super_container">
                
                <HomeContainer />
                <SecondLandingRow />

                <div className="products">

                </div>
                
                <div className="avds_xl">
                    <div className="container">
                        <div className="row">
                            <div className="col">
                                <div className="avds_xl_container clearfix">
                                    <div className="avds_xl_background" style={{ backgroundImage: `url("https://shopperstar.s3.amazonaws.com/avds_xl.jpg")` }}></div>
                                    <div className="avds_xl_content">
                                        <div className="avds_title">COWIN E7 Active</div>
                                        <div className="avds_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus.</div>
                                        <div className="avds_link avds_xl_link"><a href={this.headphonesDetailed}>See More</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <IconBoxes />
                
                <Newsletter newsletterTitle="Subscribe to our newsletter"
                            newsletterText="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros"
                            newsletterButtonText="Subscribe" />
            </div>
        ); 
    }
} 

export default Landing;