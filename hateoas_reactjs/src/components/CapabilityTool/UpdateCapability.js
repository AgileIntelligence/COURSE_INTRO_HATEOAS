import React, { Component } from "react";
import classnames from "classnames";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import {
  getCapabilityById,
  updateCapability
} from "../../actions/CapabilityActions";

export class UpdateCapability extends Component {
  state = {
    id: "",
    techStack: "",
    numOfDevelopers: 0,
    numOfAvailableDevelopers: 0,
    _links: "",
    errors: {}
  };

  onChange = e => {
    this.setState({ [e.target.name]: e.target.value });
  };

  componentWillMount() {
    this.props.getCapabilityById(this.props.id);
  }

  UNSAFE_componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }

    const {
      id,
      techStack,
      numOfDevelopers,
      numOfAvailableDevelopers,
      _links
    } = nextProps.capability;

    this.setState({
      id,
      techStack,
      numOfDevelopers,
      numOfAvailableDevelopers,
      _links
    });
  }

  onSubmit = e => {
    e.preventDefault();
    const {
      id,
      techStack,
      numOfDevelopers,
      numOfAvailableDevelopers
    } = this.state;

    const updatedCapability = {
      id,
      techStack,
      numOfDevelopers,
      numOfAvailableDevelopers
    };

    this.props.updateCapability(
      updatedCapability,
      this.props.closeModal,
      this.state._links.updateThisCapability.href
    );
  };

  render() {
    const { errors } = this.state;
    console.log("techStack: " + this.state.techStack);

    return (
      <div className="card mb-3">
        <div className="card-header bg-danger text-light">
          Update Capability
        </div>
        <div className="card-body">
          <form onSubmit={this.onSubmit}>
            <div className="form-group">
              <label htmlFor="techStack">Technology Stack</label>
              <input
                type="text"
                name="techStack"
                value={this.state.techStack}
                className={classnames("form-control form-control-lg", {
                  "is-invalid": errors.techStack
                })}
                onChange={this.onChange}
              />
              {errors.techStack && (
                <div className="invalid-feedback">{errors.techStack}</div>
              )}
            </div>
            <div className="form-group">
              <label htmlFor="numOfDevelopers">
                Total Developers in Capability
              </label>
              <input
                type="number"
                name="numOfDevelopers"
                value={this.state.numOfDevelopers}
                className="form-control form-control-lg"
                onChange={this.onChange}
              />
            </div>
            <div className="form-group">
              <label htmlFor="numOfAvailableDevelopers">
                Available developers for hire
              </label>
              <input
                type="number"
                name="numOfAvailableDevelopers"
                value={this.state.numOfAvailableDevelopers}
                className="form-control form-control-lg"
                onChange={this.onChange}
              />
            </div>
            <input
              type="submit"
              value="Update Capability"
              className="btn btn-danger btn-block"
            />
          </form>
        </div>
      </div>
    );
  }
}

UpdateCapability.propTypes = {
  getCapabilityById: PropTypes.func.isRequired,
  updateCapability: PropTypes.func.isRequired,
  closeModal: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  capability: state.capability.capability,
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { getCapabilityById, updateCapability }
)(UpdateCapability);
