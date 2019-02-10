import React, { Component } from "react";
import Modal from "react-modal";
import AddCapability from "./AddCapability";

const customStyles = {
  content: {
    height: "500px"
  }
};

export class AddButton extends Component {
  state = {
    modalIsOpen: false
  };

  openModal = () => {
    this.setState({ modalIsOpen: true });
  };

  closeModal = () => {
    this.setState({ modalIsOpen: false });
  };

  render() {
    return (
      <div>
        <React.Fragment>
          <button
            type="button"
            className="btn btn-outline-primary mb-3 text-left"
            onClick={this.openModal}
          >
            <i className="far fa-plus-square" /> Add Capability
          </button>
          <Modal isOpen={this.state.modalIsOpen} style={customStyles}>
            <button
              type="button"
              className="btn btn-danger mb-2"
              onClick={this.closeModal}
            >
              <i className="far fa-times-circle mr-1 " />
              Close Modal
            </button>
            <AddCapability closeModal={this.closeModal} />
          </Modal>
        </React.Fragment>
      </div>
    );
  }
}

export default AddButton;
