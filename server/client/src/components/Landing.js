import React from 'react';

import Product from "./Product";
import Newsletter from "./Newsletter";
import IconBoxes from "./IconBoxes";
import HomeContainer from "./HomeContainer";
import SecondLandingRow from "./SecondLandingRow";
 
import amazingImage from "./images/avds_xl.jpg";

import Product1 from "./images/product_1.jpg"; 
import Product2 from "./images/product_2.jpg"; 
import Product3 from "./images/product_3.jpg"; 
import Product4 from "./images/product_4.jpg"; 
import Product5 from "./images/product_5.jpg";
import Product6 from "./images/product_6.jpg"; 
import Product7 from "./images/product_7.jpg"; 
import Product8 from "./images/product_8.jpg"; 

class Landing extends React.Component { 
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
                                    <Product image={Product1} extra="product_new" extraTitle="New" title="SmartPhone" price="$1000" />
                                    <Product image={Product2} extra="product_sale" extraTitle="New" title="SmartPhone" price="$999" />
                                    <Product image={Product3} title="Smart Phone" price="$670"/>
                                    <Product image={Product4} title="Smart Phone" price="$999"/>
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
                                    <div className="avds_xl_background" style={{ backgroundImage: `url(${amazingImage})` }}></div>
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