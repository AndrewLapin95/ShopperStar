import React from "react";
import URLSearchParams from "url-search-params";
import Product from "./Product";

class ProductList extends React.Component {
    
    constructor(props) {
        super(props);
    }
    
    render() {

        const products = this.props.products.map((image) => {
            return <Product key={image.id} id = {image.id} image={image.image} title={image.title} category="false"/>
        });


        return (
                <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="product_grid">
                            {products}
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default ProductList;