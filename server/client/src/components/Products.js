import React from "react"; 
import Product from "./Product";

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

class Products extends React.Component { 
    render() { 
        return (
            <div className="super_container">
                <div class="products">
                    <div class="search_menu">
                        <div class="row">
                            <div class="col-lg-8 offset-lg-2">
                                <div class="search_menu_content text-center">
                                    <div class="search_menu_text">What are you looking for today?</div>
                                    <div class="search_menu_form_container">
                                        <form action="#" id="search_menu_form" class="search_menu_form">
                                            <input type="text" class="search_menu_input" required="required" />
                                            <button class="search_menu_button trans_200"><span>Search</span></button>
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
                                    
                                    <Product image={Product1} title="Smart Phone"/>
                                    <Product image={Product2} title="Laptops"/>
                                    <Product image={Product3} title="Cameras"/>
                                    <Product image={Product4} title="Headphones"/>
                                    <Product image={Product5} title="Headphones"/>
                                    <Product image={Product6} title="Headphones"/>
                                    <Product image={Product7} title="Headphones"/>
                                    <Product image={Product8} title="Headphones"/>

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