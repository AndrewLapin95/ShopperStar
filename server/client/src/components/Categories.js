import React from "react"; 
import Product from "./Product";
import Newsletter from "./Newsletter";

class Categories extends React.Component {
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
                <div class="products">
                    <div class="container">
                        <div class="row">
                            <div class="col">

                                <div class="product_grid">
                                    <Product image={this.firstProductUrl} title="Phones" />
                                    <Product image={this.secondProductUrl} title="Laptops" />
                                    <Product image={this.thirdProductUrl} title="Cameras" />
                                    <Product image={this.fourthProductUrl} title="Headphones" />
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