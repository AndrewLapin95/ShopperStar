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

class Categories extends React.Component { 
    render() { 
        return (
            <div className="super_container">
                <div class="products">
                    <div class="container">
                        <div class="row">
                            <div class="col">

                                <div class="product_grid">

                                    <Product image={Product1} title="Phones" />
                                    <Product image={Product2} title="Laptops" />
                                    <Product image={Product3} title="Cameras" />
                                    <Product image={Product4} title="Headphones" />
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

export default Categories;