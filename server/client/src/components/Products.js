import React from "react"; 
import Product from "./Product"
import SearchMenu from "./SearchMenu"
import IconBoxes from "./IconBoxes"

class Products extends React.Component { 
    constructor(props) {
        super(props);
        this.firstProductUrl = "https://shopperstar.s3.amazonaws.com/product_1.jpg";
        this.secondProductUrl = "https://shopperstar.s3.amazonaws.com/product_2.jpg";
        this.thirdProductUrl = "https://shopperstar.s3.amazonaws.com/product_3.jpg";
        this.fourthProductUrl = "https://shopperstar.s3.amazonaws.com/product_4.jpg";
        this.fifthProductUrl = "https://shopperstar.s3.amazonaws.com/product_5.jpg";
        this.sixthProductUrl = "https://shopperstar.s3.amazonaws.com/product_6.jpg";
        this.seventhProductUrl = "https://shopperstar.s3.amazonaws.com/product_7.jpg";
        this.eighthProductUrl = "https://shopperstar.s3.amazonaws.com/product_8.jpg";
    }

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
                                    <Product image={this.firstProductUrl} title="Smart Phone"/>
                                    <Product image={this.secondProductUrl} title="Laptops"/>
                                    <Product image={this.thirdProductUrl} title="Cameras"/>
                                    <Product image={this.fourthProductUrl} title="Headphones"/>
                                    <Product image={this.fifthProductUrl} title="Headphones"/>
                                    <Product image={this.sixthProductUrl} title="Headphones"/>
                                    <Product image={this.seventhProductUrl} title="Headphones"/>
                                    <Product image={this.eighthProductUrl} title="Headphones"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <IconBoxes />

                </div>
            </div>
        ) 
    } 
} 

export default Products;