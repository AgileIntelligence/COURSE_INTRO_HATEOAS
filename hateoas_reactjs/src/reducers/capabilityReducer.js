import { GET_CAPABILITIES, DELETE_CAPABILITY } from "../actions/ActionTypes";

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
        capabilities: action.payload
      };

    case DELETE_CAPABILITY:
      return {
        ...state,
        capabilities: state.capabilities.filter(
          capability => capability.id !== action.payload
        )
      };

    default:
      return state;
  }
}
