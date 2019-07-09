import React from "react";
import Newsletter from "./Newsletter";

import Icon1 from "./images/icon_1.svg"; 
import Icon2 from "./images/icon_2.svg";
import Icon3 from "./images/icon_3.svg"; 

class ReturnPage extends React.Component { 
    render() { 
        return (
            <div className="super_container">
                <div class="return_page">
                    <div class="row">
                        <div class="col-lg-8 offset-lg-2">
                            <div class="return_content text-center">
                                <div class="return_text">Your order has been placed!</div>
                                <div class="return_form_container">
                                    <form action="/" id="return_form" className="return_form">
                                        <button class="return_button trans_200"><span>Continue Shopping</span></button>
                                    </form>
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

                <Newsletter newsletterTitle="Subscribe to our newsletter"
                            newsletterText="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros"
                            newsletterButtonText="Subscribe" />
            </div>
        ) 
    } 
} 

export default ReturnPage;