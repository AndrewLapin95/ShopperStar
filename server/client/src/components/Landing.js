import React from 'react';

import Product from "./Product";
import Newsletter from "./Newsletter";
import IconBoxes from "./IconBoxes";
import HomeContainer from "./HomeContainer";
import SecondLandingRow from "./SecondLandingRow";

class Landing extends React.Component {
    constructor(props) {
        super(props);
        this.firstProductUrl = "https://shopperstar.s3.amazonaws.com/product_1.jpg";
        this.secondProductUrl = "https://shopperstar.s3.amazonaws.com/product_2.jpg";
        this.thirdProductUrl = "https://shopperstar.s3.amazonaws.com/product_3.jpg";
        this.fourthProductUrl = "https://shopperstar.s3.amazonaws.com/product_4.jpg";
    }

    render() { 
        return (
            <div className="super_container">
                
                <HomeContainer />
                <SecondLandingRow />

                <div className="products">
                    <div className="container">
                        <div className="row">
                            <div className="col">

                                <div className="product_grid">
                                    <Product image={this.firstProductUrl} extra="product_new" extraTitle="New" title="SmartPhone" price="$1000" />
                                    <Product image={this.secondProductUrl} extra="product_sale" extraTitle="New" title="SmartPhone" price="$999" />
                                    <Product image={this.thirdProductUrl} title="Smart Phone" price="$670"/>
                                    <Product image={this.fourthProductUrl} title="Smart Phone" price="$999"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div className="avds_xl">
                    <div className="container">
                        <div className="row">
                            <div className="col">
                                <div className="avds_xl_container clearfix">
                                    <div className="avds_xl_background" style={{ backgroundImage: `url("https://shopperstar.s3.amazonaws.com/avds_xl.jpg")` }}></div>
                                    <div className="avds_xl_content">
                                        <div className="avds_title">Amazing Devices</div>
                                        <div className="avds_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus.</div>
                                        <div className="avds_link avds_xl_link"><a href="categories.html">See More</a></div>
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