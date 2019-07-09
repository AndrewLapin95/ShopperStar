import React from "react";

class Product extends React.Component {
    
    constructor(props) {
        super(props);
        this.imageRef = React.createRef();
    }

    verifyPrice() {

        let priceElement;

        if (this.props.price != "") {
            priceElement = <div className="product_price">{this.props.price}</div>;
        } else {
            priceElement = "";
        }

        return priceElement;
    }

    verifyExtraElement() {
        let extraElement;

        if (this.props.extra != "") {
            extraElement = <div className={"product_extra " + this.props.extra}>
                                <a href="categories.html">{this.props.extraTitle}</a>
                            </div>;
        } else {
            extraElement = "";
        }

        return extraElement;
    }

    render() {

        return (
            <div className="product">
                <div className="product_image"><img src={this.props.image} alt="" /></div>
                {this.verifyExtraElement()}
                <div className="product_content">
                    <div className="product_title"><a href="product.html">{this.props.title}</a></div>
                    {this.verifyPrice()}
                </div>
            </div>
        );
    }
}

export default Product;