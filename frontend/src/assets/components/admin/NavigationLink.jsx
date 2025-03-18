import { NavLink } from "react-router-dom";
import PropTypes from "prop-types";

export default function NavigationLink({
  linkName,
  linkIcon,
  activeLink,
  handleActiveLinkName,
}) {
  return (
    <NavLink
      title={linkName[0].toUpperCase() + linkName.slice(1)}
      to={`${linkName === "dashboard" ? "" : linkName}`}
      className={`flex text-large items-center gap-3 p-5 rounded-lg ${activeLink === linkName ? "bg-primary text-light" : "bg-transparent text-gray"} `}
      onClick={() => handleActiveLinkName(linkName)}
    >
      <span>{linkIcon}</span>
      <span className="hidden sm:block">
        {linkName[0].toUpperCase() + linkName.slice(1)}
      </span>
    </NavLink>
  );
}

NavigationLink.propTypes = {
  linkName: PropTypes.string,
  link: PropTypes.element,
  activeLink: PropTypes.string,
  handleActiveLinkName: PropTypes.func,
};
