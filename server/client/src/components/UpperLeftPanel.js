import React from 'react';

import CartIcon from "./CartIcon";
import Authorization from "./Authorization";

class UpperLeftPanel extends React.Component {
    render() {
        return (
            <div className="header_extra ml-auto">
                <div className="upper_left_panel">
                    <CartIcon />
                    <Authorization />
                </div>
            </div>
        )
    }
}

export default UpperLeftPanel;