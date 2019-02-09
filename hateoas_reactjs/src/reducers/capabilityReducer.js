import { GET_CAPABILITIES } from "../actions/ActionTypes";

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

    default:
      return state;
  }
}
