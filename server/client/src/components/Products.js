import React from "react"; 
import Product from "./Product"
import SearchMenu from "./SearchMenu";

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

                    <SearchMenu text="What are you looking for today?"
                                button="Search" />

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