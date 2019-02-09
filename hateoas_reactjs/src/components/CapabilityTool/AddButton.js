import React, { Component } from "react";

export class AddButton extends Component {
  render() {
    return (
      <div>
        <React.Fragment>
          <button
            type="button"
            className="btn btn-outline-primary mb-3 text-left"
          >
            <i className="far fa-plus-square" /> Add Capability
          </button>
        </React.Fragment>
      </div>
    );
  }
}

export default AddButton;
