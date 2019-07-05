import React from "react"; 

import Icon1 from "./images/icon_1.svg"; 
import Icon2 from "./images/icon_2.svg"; import Icon3 from "./images/icon_3.svg"; 

import Product1 from "./images/product_1.jpg"; 
import Product2 from "./images/product_2.jpg"; 
import Product3 from "./images/product_3.jpg"; 
import Product4 from "./images/product_4.jpg"; 
import Product5 from "./images/product_5.jpg"; 
import Product6 from "./images/product_6.jpg"; 
import Product7 from "./images/product_7.jpg"; 
import Product8 from "./images/product_8.jpg";

class Products extends React.Component { 
    render() { 
        return (
            <div className="super_container">

                <div class="products">
                    <div class="newsletter">

                        <div class="row">
                            <div class="col-lg-8 offset-lg-2">
                                <div class="newsletter_content text-center">
                                    <div class="newsletter_title">What are you looking for today?</div>
                                    <div class="newsletter_form_container">
                                        <form action="#" id="newsletter_form" class="newsletter_form">
                                            <input type="text" class="newsletter_input" required="required" />
                                            <button class="newsletter_button trans_200"><span>Search</span></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col">

                                <div class="product_grid">

                                    <div class="product">
                                        <div class="product_image"><img src={Product1} alt="" /></div>
                                        <div class="product_content">
                                            <div class="product_title"><a href="product.html">Smart Phones</a></div>
                                        </div>
                                    </div>

                                    <div class="product">
                                        <div class="product_image"><img src={Product2} alt="" /></div>
                                        <div class="product_content">
                                            <div class="product_title"><a href="product.html">Laptops</a></div>
                                        </div>
                                    </div>

                                    <div class="product">
                                        <div class="product_image"><img src={Product3} alt="" /></div>
                                        <div class="product_content">
                                            <div class="product_title"><a href="product.html">Cameras</a></div>
                                        </div>
                                    </div>

                                    <div class="product">
                                        <div class="product_image"><img src={Product4} alt="" /></div>
                                        <div class="product_content">
                                            <div class="product_title"><a href="product.html">Headphones</a></div>
                                        </div>
                                    </div>

                                    <div class="product">
                                        <div class="product_image"><img src={Product5} alt="" /></div>
                                        <div class="product_content">
                                            <div class="product_title"><a href="product.html">Headphones</a></div>
                                        </div>
                                    </div>

                                    <div class="product">
                                        <div class="product_image"><img src={Product6} alt="" /></div>
                                        <div class="product_content">
                                            <div class="product_title"><a href="product.html">Headphones</a></div>
                                        </div>
                                    </div>

                                    <div class="product">
                                        <div class="product_image"><img src={Product7} alt="" /></div>
                                        <div class="product_content">
                                            <div class="product_title"><a href="product.html">Headphones</a></div>
                                        </div>
                                    </div>

                                    <div class="product">
                                        <div class="product_image"><img src={Product8} alt="" /></div>
                                        <div class="product_content">
                                            <div class="product_title"><a href="product.html">Headphones</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ) 
    } 
} 

export default Products;