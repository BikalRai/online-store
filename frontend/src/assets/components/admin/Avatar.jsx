export default function Avatar() {
  return (
    <div className="h-16 w-16 overflow-hidden rounded-full">
      <img
        src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVyc29ufGVufDB8fDB8fHww"
        alt=""
        className="h-full w-full cursor-pointer object-cover"
      />
    </div>
  );
}
