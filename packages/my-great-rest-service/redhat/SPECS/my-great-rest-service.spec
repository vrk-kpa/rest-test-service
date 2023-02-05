# do not repack jars
%define __jar_repack %{nil}
%define dist %(/usr/lib/rpm/redhat/dist.sh)

Name:               my-great-rest-service
Version:            %{project_version}
Release:            %{rel}%{?snapshot}%{?dist}
Summary:            X-Road Catalog test service
Group:              Applications/Internet
License:            MIT
Requires:           systemd, java-11-openjdk
Requires(post):     systemd
Requires(preun):    systemd
Requires(postun):   systemd

%define src %{_topdir}
%define jlib /usr/lib/my-great-rest-service

%description
X-Road test service

%prep

%build

%install
mkdir -p %{buildroot}%{jlib}
mkdir -p %{buildroot}%{_unitdir}
mkdir -p %{buildroot}/usr/share/xroad/bin
cp -p %{src}/../../../build/libs/MyGreatRestService-%{version}.jar %{buildroot}%{jlib}/%{name}.jar

%clean
rm -rf %{buildroot}

%files
%attr(644,root,root) %{_unitdir}/%{name}.service
%attr(755,xroad-catalog,xroad-catalog) %{jlib}/%{name}.jar
%attr(744,xroad-catalog,xroad-catalog) /usr/share/xroad/bin/%{name}

%pre
if ! id xroad-catalog > /dev/null 2>&1 ; then
    adduser --system --no-create-home --shell /bin/false xroad-catalog
fi

%post
%systemd_post %{name}.service

%preun
%systemd_preun %{name}.service

%postun
%systemd_postun_with_restart %{name}.service

%changelog

