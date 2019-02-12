import {
  GET_CAPABILITIES,
  DELETE_CAPABILITY,
  ADD_CAPABILITY,
  GET_CAPABILITY,
  CLEAR_CAPABILITY_CLOSE_MODAL,
  UPDATE_CAPABILITY
} from "../actions/ActionTypes";

const initialState = {
  capabilities: [],
  capability: {},
  links: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_CAPABILITIES:
      return {
        ...state,
        capabilities: action.payload,
        links: action.links
      };

    case DELETE_CAPABILITY:
      return {
        ...state,
        capabilities: state.capabilities.filter(
          capability => capability.id !== action.payload
        )
      };

    case ADD_CAPABILITY:
      return {
        ...state,
        capabilities: [action.payload, ...state.capabilities]
      };

    case GET_CAPABILITY:
      return {
        ...state,
        capability: state.capabilities.find(
          capability => capability.id === action.payload
        )
      };

    case CLEAR_CAPABILITY_CLOSE_MODAL:
      return {
        ...state,
        capability: action.payload
      };

    case UPDATE_CAPABILITY:
      return {
        ...state,
        capabilities: state.capabilities.map(capability =>
          capability.id === action.payload.id
            ? (capability = action.payload)
            : capability
        )
      };

    default:
      return state;
  }
}
