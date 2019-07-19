import React from "react";

class IconBox extends React.Component {
    render() {
        return (
            <div className="col-lg-4 icon_box_col">
                <div className="icon_box">
                    <div className="icon_box_image"><img src={this.props.image} alt="" /></div>
                    <div className="icon_box_title">{this.props.title}</div>
                    <div className="icon_box_text">
                        <p>{this.props.text}</p>
                    </div>
                </div>
            </div>
        );
    }
}

class IconBoxes extends React.Component {
    
    constructor(props) {
        super(props);
        this.firstIcon = "https://shopperstar.s3.amazonaws.com/icon_1.svg";
        this.secondIcon = "https://shopperstar.s3.amazonaws.com/icon_2.svg";
        this.thirdIcon = "https://shopperstar.s3.amazonaws.com/icon_3.svg";
    }

    render() {
        return (
            <div className="icon_boxes">
                    <div className="container">
                        <div className="row icon_box_row">
                            <IconBox image={this.firstIcon} 
                                     title="Free Shipping Worldwide"
                                     text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie." />

                            <IconBox image={this.secondIcon} 
                                     title="Free Returns"
                                     text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie." />

                            <IconBox image={this.thirdIcon} 
                                     title="24h Fast Support"
                                     text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie." />
                        </div>
                    </div>
                </div>
        );
    }
}

export default IconBoxes;