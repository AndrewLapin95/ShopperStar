import React from 'react'; 

import backgroundImage from "./images/home_slider_1.jpg"; 
import discountImage from "./images/discount.png"; 
import amazingImage from "./images/avds_xl.jpg"; 

import Icon1 from "./images/icon_1.svg"; 
import Icon2 from "./images/icon_2.svg";
import Icon3 from "./images/icon_3.svg"; 

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
                <div class="home">
                    <div class="home_container">
                        <div class="home_background" style={{ backgroundImage: `url(${backgroundImage})` }}></div>
                        <div class="home_content_container">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        <div class="home_slider_content" data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                            <div class="home_slider_title">A new Online Shop experience</div>
                                            <div class="home_slider_subtitle">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros. Sed viverra velit venenatis fermentum luctus.</div>
                                            <div class="button button_light home_button"><a href="#">Shop Now</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="avds">
                    <div className="avds_container d-flex flex-lg-row flex-column align-items-start justify-content-between">
                        <div className="avds_small">
                            <div className="avds_background" style={{ backgroundImage: `url(${backgroundImage})` }}></div>
                            <div className="avds_small_inner">
                                <div className="avds_discount_container">
                                    <img src={discountImage} alt="" />
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
                            <div className="avds_background" style={{ backgroundImage: `url(${backgroundImage})` }}></div>
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

                <div className="products">
                    <div className="container">
                        <div className="row">
                            <div className="col">

                                <div className="product_grid">

                                    <div className="product">
                                        <div className="product_image"><img src={Product1} alt="" /></div>
                                        <div className="product_extra product_new"><a href="categories.html">New</a></div>
                                        <div className="product_content">
                                            <div className="product_title"><a href="product.html">Smart Phone</a></div>
                                            <div className="product_price">$670</div>
                                        </div>
                                    </div>

                                    <div className="product">
                                        <div className="product_image"><img src={Product2} alt="" /></div>
                                        <div className="product_extra product_sale"><a href="categories.html">Sale</a></div>
                                        <div className="product_content">
                                            <div className="product_title"><a href="product.html">Smart Phone</a></div>
                                            <div className="product_price">$670</div>
                                        </div>
                                    </div>

                                    <div className="product">
                                        <div className="product_image"><img src={Product3} alt="" /></div>
                                        <div className="product_content">
                                            <div className="product_title"><a href="product.html">Smart Phone</a></div>
                                            <div className="product_price">$670</div>
                                        </div>
                                    </div>

                                    <div className="product">
                                        <div className="product_image"><img src={Product4} alt="" /></div>
                                        <div className="product_content">
                                            <div className="product_title"><a href="product.html">Smart Phone</a></div>
                                            <div className="product_price">$670</div>
                                        </div>
                                    </div>
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

                <div className="icon_boxes">
                    <div className="container">
                        <div className="row icon_box_row">
                            <div className="col-lg-4 icon_box_col">
                                <div className="icon_box">
                                    <div className="icon_box_image"><img src={Icon1} alt="" /></div>
                                    <div className="icon_box_title">Free Shipping Worldwide</div>
                                    <div className="icon_box_text">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
                                    </div>
                                </div>
                            </div>

                            <div className="col-lg-4 icon_box_col">
                                <div className="icon_box">
                                    <div className="icon_box_image"><img src={Icon2} alt="" /></div>
                                    <div className="icon_box_title">Free Returns</div>
                                    <div className="icon_box_text">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
                                    </div>
                                </div>
                            </div>

                            <div className="col-lg-4 icon_box_col">
                                <div className="icon_box">
                                    <div className="icon_box_image"><img src={Icon3} alt="" /></div>
                                    <div className="icon_box_title">24h Fast Support</div>
                                    <div className="icon_box_text">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <div className="newsletter">
                    <div className="container">
                        <div className="row">
                            <div className="col">
                                <div className="newsletter_border"></div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-lg-8 offset-lg-2">
                                <div className="newsletter_content text-center">
                                    <div className="newsletter_title">Subscribe to our newsletter</div>
                                    <div className="newsletter_text">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros</p>
                                    </div>
                                    <div className="newsletter_form_container">
                                        <form action="#" id="newsletter_form" className="newsletter_form">
                                            <input type="email" className="newsletter_input" required="required" />
                                            <button className="newsletter_button trans_200"><span>Subscribe</span></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    }
} 

export default Landing;