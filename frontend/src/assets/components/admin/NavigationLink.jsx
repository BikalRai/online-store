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
      to={`${linkName === "dashboard" ? "/" : `/${linkName}`}`}
      className={`text-large flex items-center gap-3 rounded-lg p-5 ${activeLink === linkName ? "bg-primary text-light" : "text-gray bg-transparent"} hover:text-light hover:bg-primary transition-all`}
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
