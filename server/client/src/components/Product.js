import React from "react";
import Fade from 'react-reveal/Fade';

class Product extends React.Component {
    
    constructor(props) {
        super(props);
        this.imageRef = React.createRef();
    }

    getImageUrl() {
        if (this.props.category === "false") {
            return "/product/" + this.props.id;
        } else {
            return this.props.src;
        }
    }

    verifyPrice() {

        let priceElement;

        if (this.props.price !== "") {
            priceElement = <div className="product_price">{this.props.price}</div>;
        } else {
            priceElement = "";
        }

        return priceElement;
    }

    verifyExtraElement() {
        let extraElement;

        if (this.props.extra !== "") {
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
            <Fade>
                <div key={this.props.id} className="product">
                    <div className="product_image"><img src={this.props.image} alt="" height="190" width="225" /></div>
                    {this.verifyExtraElement()}
                    <div className="product_content">
                        <div className="product_title"><a href={this.getImageUrl()}>{this.props.title}</a></div>
                        {this.verifyPrice()}
                    </div>
                </div>
            </Fade>
        );
    }
}

export default Product;