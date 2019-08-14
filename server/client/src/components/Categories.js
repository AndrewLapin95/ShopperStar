import React from "react"; 
import Product from "./Product";
import Newsletter from "./Newsletter";
import IconBoxes from "./IconBoxes";

class Categories extends React.Component {
    constructor(props) {
        super(props);
        this.isCategory = "true"
        this.firstProductUrl = "https://shopperstar.s3.amazonaws.com/product4_1.jpg";
        this.secondProductUrl = "https://shopperstar.s3.amazonaws.com/product8_1.jpg";
        this.thirdProductUrl = "https://shopperstar.s3.amazonaws.com/product13_1.jpg";
        this.fourthProductUrl = "https://shopperstar.s3.amazonaws.com/product18_1.jpg";
    }

    render() { 
        return (
            <div className="super_container">
                <div class="products">
                    <div class="container">
                        <div class="row">
                            <div class="col">

                                <div class="product_grid">
                                    <Product image={this.firstProductUrl} title="Phones" category={this.isCategory} src="/products?category=phones" />
                                    <Product image={this.secondProductUrl} title="Laptops" category={this.isCategory} src="/products?category=laptops" />
                                    <Product image={this.thirdProductUrl} title="Cameras" category={this.isCategory} src="/products?category=cameras" />
                                    <Product image={this.fourthProductUrl} title="Headphones" category={this.isCategory} src="/products?category=headphones" />
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
        ) 
    } 
} 

export default Categories;